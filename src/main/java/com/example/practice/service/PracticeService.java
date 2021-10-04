package com.example.practice.service;

import com.example.practice.entity.Practice;
import com.example.practice.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

    // 글 리스트 처리
    public Page<Practice> practiceList(Pageable pageable) {

        return practiceRepository.findAll(pageable);
    }
    // 조회수 증가
    public void practiceHit(Integer id) {

        Practice practice = practiceRepository.findById(id).get();
        practice.setHit(practice.getHit() + 1);
        practiceRepository.save(practice);
    }
    // 글 작성 처리
    public void practiceWrite(Practice practice) {

        practiceRepository.save(practice);
    }
    // 특정 게시글 불러오기
    public Practice practiceView(Integer id) {

        return practiceRepository.findById(id).get();
    }
    // 글 수정 처리             // 수정하기 위해 받은 객체
    public void practiceUpdate(Practice practice) {
        // 수정할 때 제목, 내용, 이름 수정 가능

        // 기존에 있던 글
        Practice past = practiceRepository.findById(practice.getId()).get();

        // 수정하기 위해 갖고 온 객체에 날짜 설정
        practice.setReg_date(past.getReg_date());
        // 수정한 글 저장 -> 기존에 있던 객체에 글 수정 이뤄진 걸 저장
        practiceRepository.save(practice);
    }
    // 특정 게시글 삭제
    public void practiceDelete(Integer id) {

        practiceRepository.deleteById(id);
    }
}
