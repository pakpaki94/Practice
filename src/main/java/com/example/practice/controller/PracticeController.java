package com.example.practice.controller;

import com.example.practice.entity.Practice;
import com.example.practice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @GetMapping("/practice/list")
    public String practiceList(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC, sort = "id")Pageable pageable) {
        model.addAttribute("list",practiceService.practiceList(pageable));

        return "practicelist";
    }

    @GetMapping("/practice/write")
    public String practiceWrite() {

        return "practicewrite";
    }

    @PostMapping("/practice/writepro")
    public String practiceWritePro(Practice practice) {

        practiceService.practiceWrite(practice);
        return "redirect:/practice/list";
    }

    @GetMapping("/practice/view")
    public String practiceView(Model model, Integer id){

        practiceService.practiceHit(id);
        model.addAttribute("practice", practiceService.practiceView(id));
        return "practiceview";
    }

    @GetMapping("/practice/update")
    public String practiceUpdate(Model model, Integer id) {

        model.addAttribute("practice", practiceService.practiceView(id));
        return "practiceupdate";
    }

    @GetMapping("/practice/delete")
    public String practiceDelete(Integer id) {

        practiceService.practiceDelete(id);
        return "redirect:/practice/list";
    }
}
