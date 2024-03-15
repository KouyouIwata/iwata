package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diarys")
public class DiaryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long diaryId;
    
    @Column(length = 32, nullable = false)
    private String content;

    

    // diaryIdのゲッターセッター
    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    // contentのゲッターセッター
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
