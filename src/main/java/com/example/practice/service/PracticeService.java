package com.example.practice.service;

import com.example.practice.entity.Practice;
import com.example.practice.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;


    // 글 리스트 처리
    public Page<Practice> practiceList(Pageable pageable) {

        return practiceRepository.findAll(pageable);
    }
    // 글 작성 처리
    public void write(Practice practice) {

        practiceRepository.save(practice);
    }
    // 특정 게시글 불러오기
    public Practice practiceView(Integer id) {

        return practiceRepository.findById(id).get();
    }
    // 특정 게시글 삭제
    public void practiceDelete(Integer id) {

        practiceRepository.deleteById(id);
    }
}
