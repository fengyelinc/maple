package com.cc.backend.dao.vo;

import com.cc.backend.dao.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MenuTreeVO {
    private Menu menu;
    private List<MenuTreeVO> children =new ArrayList<>();
}
