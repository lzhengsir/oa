package com.gcc.controller;

import com.gcc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lzhen
 * @since: 2023/1/19 23:47
 * @description:
 */
@RestController
@Api(tags = "测试")
public class TestController {
    @ApiOperation("你好")
    @GetMapping("/hello")
    public Result sayHello(String name) {
        return Result.ok().data("item", "hello " + name);
    }
}
