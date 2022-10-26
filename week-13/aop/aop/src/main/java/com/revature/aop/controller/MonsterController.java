package com.revature.aop.controller;

import com.revature.aop.entity.Monster;
import com.revature.aop.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // includes the @Controller annotation (stereotype) as well as the @ResponseBody we'll have GET, POST, DELETE, methods, etc. and
// it will be a spring bean
@RequestMapping("/monsters") // A lot of the time, we use @RequestMapping at the class level to give a prefix to
// all of the endpoints that we define in this class
public class MonsterController {
    @Autowired
    MonsterService monsterService;

    // full path would be "/monsters" because we defined the RequestMapping at the class level
    @PostMapping()
    public Monster add(@RequestBody Monster monster) {
        return monsterService.upsert(monster);
    }

    // We can use the @RequestMapping annotation at the method level, we just need to manually
    // specify the type of HTTP request
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Monster> getAll() {
        return monsterService.getAll();
    }

    // if we use the more specific annotation, we know that this will be a Get Mapping
    @GetMapping("/{id}")
    // for path variable, make sure we match what we specified in the GetMapping:
    public Monster getById(@PathVariable("id") Long id) {
        return monsterService.getById(id);
    }

    @PutMapping()
    public Monster update(@RequestBody Monster monster) {
        return monsterService.upsert(monster);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        monsterService.delete(id);
    }
}
