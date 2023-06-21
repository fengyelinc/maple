package com.cc.backend.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.dao.entity.Menu;
import com.cc.backend.dao.vo.MenuTreeVO;
import com.cc.backend.mapper.MenuMapper;
import com.cc.backend.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * [
     *  {id:
     *   url:
     *   childern:[{},{}]
     *   },
     * ]
     * @param roleId
     * @return
     */
    @Override
    public List<MenuTreeVO> getListByRid(Long roleId) {
        List<Menu> menuList = menuMapper.selectList(new LambdaQueryWrapper<Menu>().eq(Menu::getRid, roleId));
        Map<Long, MenuTreeVO> menuMap = new HashMap<>();
        List<MenuTreeVO> parnetTree = new ArrayList<>();
        // 获取所有顶级菜单
        for (Menu menu : menuList) {
            MenuTreeVO menuTreeVO = new MenuTreeVO();
            menuTreeVO.setMenu(menu);
            menuMap.put(menu.getId(), menuTreeVO);
            Long parentId = menu.getParentId();
            // 如果当前菜单项没有父级，将其添加到根列表中
            if (parentId == 0) {
                parnetTree.add(menuTreeVO);
            }
        }
        buildClildTree(parnetTree,menuList);
        return parnetTree;
    }

    public List<MenuTreeVO> buildClildTree(List<MenuTreeVO> parnetTree, List<Menu> menuList){
        for(MenuTreeVO menuTreeVO :parnetTree){
            // 递归出口
            if(CollectionUtil.isEmpty(menuList)){
                break;
            }
            // 筛选出子节点
            List<Menu> clildList = menuList.stream()
                    .filter(x -> x.getParentId() == menuTreeVO.getMenu().getId())
                    .collect(Collectors.toList());
            List<MenuTreeVO> childs = convertToMeunTree(clildList);
            if(CollectionUtil.isNotEmpty(clildList)) {
                menuTreeVO.setChildren(childs);
                menuList.removeIf(x -> x.getId() == menuTreeVO.getMenu().getId()); //将已使用的父节点踢出menuList
                buildClildTree(childs, menuList);
            }
        }
        return parnetTree;
    }

    public List<MenuTreeVO> convertToMeunTree(List<Menu> clildList){
        List<MenuTreeVO> next = new ArrayList<>();
        clildList.forEach(x -> {
            MenuTreeVO tree = new MenuTreeVO();
            tree.setMenu(x);
            next.add(tree);
        });
        return next;
    }
}

