package com.confirm.confirm.service;

import com.confirm.confirm.dto.FairListData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// stub 클래스이며 이후 추가 예정.
@Service
public class FairService {
    public List<FairListData> getFairList() {
        return List.of(new FairListData(
                "images/firm1.png",
                "LX 지리데이터 행사",
                "LX 한국국토정보공사",
                "지리, 공간 데이터",
                "전주시",
                "6월 25일"
        ));
    }
}
