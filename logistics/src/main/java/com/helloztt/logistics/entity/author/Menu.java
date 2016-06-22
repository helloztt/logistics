package com.helloztt.logistics.entity.author;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by helloztt on 2016/6/22.
 */
@Entity
@Table(name = "Menu")
@Cacheable(false)
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * URL
     */
    private String url;

    @OneToMany
    @JoinColumn(name = "parentMenuId")
    private List<Menu> subMenuList;
}
