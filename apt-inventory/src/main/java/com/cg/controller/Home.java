package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/products/{slug}")
    public ModelAndView showProductDetailPage(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/detail");
        modelAndView.addObject("slug", slug);
        return modelAndView;
    }

    @GetMapping("/products/update/{slug}")
    public ModelAndView showProductUpdatelPage(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/update");
        modelAndView.addObject("slug", slug);
        return modelAndView;
    }

    @GetMapping("/products/create-description")
    public ModelAndView showCreateDescriptionProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/create-description");
        return modelAndView;
    }

    @GetMapping("/products/update")
    public ModelAndView showUpdateProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/update");
        return modelAndView;
    }

    @GetMapping("/purchase-orders")
    public ModelAndView showStockInOrderListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchase-order/list");
        return modelAndView;
    }

    @GetMapping("/purchase-orders/create")
    public ModelAndView showCreateStockInOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchase-order/create");
        return modelAndView;
    }

    @GetMapping("/orders")
    public ModelAndView showOrderListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/list");
        return modelAndView;
    }

    @GetMapping("/orders/create")
    public ModelAndView showCreateOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/create");
        return modelAndView;
    }

    @GetMapping("/orders/update")
    public ModelAndView showUpdateOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/update");
        return modelAndView;
    }

    @GetMapping("/orders/adminList")
    public ModelAndView showAdminListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/adminList");
        return modelAndView;
    }

    @GetMapping("/purchase-orders/invoice")
    public ModelAndView showPurchaseOrderInvoicePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchase-order/invoice");
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
        modelAndView.setViewName("inventory/detail");
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

}
