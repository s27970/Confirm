package com.confirm.confirm.service;

import com.confirm.confirm.dto.FairCardData;
import com.confirm.confirm.entity.EventJPA;
import com.confirm.confirm.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// stub 클래스이며 이후 추가 예정.
@Service
public class FairService {
    private final EventRepository eventRepository;

    @Autowired
    public FairService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<FairCardData> getFairList() {
        List<EventJPA> eventList = eventRepository.findAll();

        System.out.println("list : ");
        eventList.forEach(event -> System.out.println(event.toString()));


        return eventList.stream()
                .map(event -> new FairCardData(
                        event.getImagePath(),
                        event.getFairName(),
                        event.getOrganizerName(),
                        event.getKeyword(),
                        event.getLocation(),
                        event.getEventTime().toString()
                ))
                .toList();
    }


}
