package com.cc.backend.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.dao.entity.Menu;
import com.cc.backend.dao.vo.MenuTree;
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
    public List<MenuTree> getListByRid(Long roleId) {
        List<Menu> menuList = menuMapper.selectList(new LambdaQueryWrapper<Menu>().eq(Menu::getRid, roleId));
        Map<Long, MenuTree> menuMap = new HashMap<>();
        List<MenuTree> parnetTree = new ArrayList<>();
        // 获取所有顶级菜单
        for (Menu menu : menuList) {
            MenuTree menuTree = new MenuTree();
            menuTree.setMenu(menu);
            menuMap.put(menu.getId(),menuTree );
            Long parentId = menu.getParentId();
            // 如果当前菜单项没有父级，将其添加到根列表中
            if (parentId == 0) {
                parnetTree.add(menuTree);
            }
        }
        buildClildTree(parnetTree,menuList);
        return parnetTree;
    }

    public List<MenuTree> buildClildTree(List<MenuTree> parnetTree,List<Menu> menuList){
        for(MenuTree menuTree:parnetTree){
            // 递归出口
            if(CollectionUtil.isEmpty(menuList)){
                break;
            }
            // 筛选出子节点
            List<Menu> clildList = menuList.stream()
                    .filter(x -> x.getParentId() == menuTree.getMenu().getId())
                    .collect(Collectors.toList());
            List<MenuTree> childs = convertToMeunTree(clildList);
            if(CollectionUtil.isNotEmpty(clildList)) {
                menuTree.setChildren(childs);
                menuList.removeIf(x -> x.getId() == menuTree.getMenu().getId()); //将已使用的父节点踢出menuList
                buildClildTree(childs, menuList);
            }
        }
        return parnetTree;
    }

    public List<MenuTree> convertToMeunTree(List<Menu> clildList){
        List<MenuTree> next = new ArrayList<>();
        clildList.forEach(x -> {
            MenuTree tree = new MenuTree();
            tree.setMenu(x);
            next.add(tree);
        });
        return next;
    }
}

