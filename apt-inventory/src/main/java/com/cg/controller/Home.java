package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class Home {

    @GetMapping
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    @GetMapping("/products/create")
    public ModelAndView showCreateProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/create");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showProductListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @GetMapping("/products/create-description")
    public ModelAndView showCreateDescriptionProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/create-description");
        return modelAndView;
    }

    @GetMapping("/products/detail")
    public ModelAndView showProductDetailPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/detail");
        return modelAndView;
    }

    @GetMapping("/products/update")
    public ModelAndView showUpdateProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/update");
        return modelAndView;
    }

    @GetMapping("/stock-in-orders")
    public ModelAndView showStockInOrderListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stock-in-order/list");
        return modelAndView;
    }

    @GetMapping("/stock-in-orders/create")
    public ModelAndView showCreateStockInOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stock-in-order/create");
        return modelAndView;
    }

    @GetMapping("/purchase-orders")
    public ModelAndView showPurchaseOrderListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stock-in-order/list");
        return modelAndView;
    }

    @GetMapping("/purchase-orders/create")
    public ModelAndView showCreatePurchaseOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stock-in-order/create");
        return modelAndView;
    }

    @GetMapping("/users/create")
    public ModelAndView showCreateUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showUserListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    @GetMapping("/inventories")
    public ModelAndView showInventoryListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inventory/overview");
        return modelAndView;
    }

    @GetMapping("/inventories/details")
    public ModelAndView showInventoryDetailPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inventory/details");
        return modelAndView;
    }

    @GetMapping("/blogs/create")
    public ModelAndView showCreateBlogPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog/create");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView showBlogListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog/list");
        return modelAndView;
    }

    @GetMapping("/demo")
    public ModelAndView showBlogListPagee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demoImage");
        return modelAndView;
    }

}
