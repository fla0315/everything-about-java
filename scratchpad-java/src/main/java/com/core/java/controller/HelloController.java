package com.core.java.controller;

import com.core.java.domain.HelloJava;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "hello")
@Slf4j
public class HelloController {

    @GetMapping()
    public List<HelloJava> get() {

        List<HelloJava> obstacleDetailInfos = new ArrayList<>();
        HelloJava a = new HelloJava();
        HelloJava b = new HelloJava();
        HelloJava c = new HelloJava();
        HelloJava d = new HelloJava();
        HelloJava e = new HelloJava();
        HelloJava f = new HelloJava();
        HelloJava g = new HelloJava();
        HelloJava h = new HelloJava();
        HelloJava i = new HelloJava();

        a.setCode("명칭1");
        a.setObsSeq(1L);

        b.setCode("명칭2");
        b.setObsSeq(1L);

        c.setCode("명칭3");
        c.setObsSeq(2L);

        d.setCode("명칭4");
        d.setObsSeq(3L);

        e.setCode("명칭5");
        e.setObsSeq(4L);

        f.setCode("명칭6");
        f.setObsSeq(5L);

        g.setCode("명칭7");
        g.setObsSeq(6L);

        h.setCode("명칭8");
        h.setObsSeq(6L);

        i.setCode("명칭9");
        i.setObsSeq(6L);

        obstacleDetailInfos.add(a);
        obstacleDetailInfos.add(b);
        obstacleDetailInfos.add(c);
        obstacleDetailInfos.add(d);
        obstacleDetailInfos.add(e);
        obstacleDetailInfos.add(f);
        obstacleDetailInfos.add(g);
        obstacleDetailInfos.add(h);
        obstacleDetailInfos.add(i);

        // obsSeq에 대한 obsDtSeq 카운터를 추적하는 Map
        Map<Long, AtomicLong> obsDtSeqCounter = new HashMap<>();

        // HelloJava 객체들을 처리하면서 obsDtSeq 값을 설정
        var obstacleDetailInfoVos = obstacleDetailInfos.stream().map(obstacleDetailDto -> {
            long obsSeq = obstacleDetailDto.getObsSeq();
            AtomicLong counter = obsDtSeqCounter.computeIfAbsent(obsSeq, k -> new AtomicLong(0L));
            long obsDtSeq = counter.incrementAndGet();
            return HelloJava.builder()
                    .code(obstacleDetailDto.getCode())
                    .obsSeq(obsSeq)
                    .obsDtSeq(obsDtSeq)
                    .build();
        }).toList();

        log.debug("obstacleDetailInfoVos = {}", obstacleDetailInfoVos);
        return obstacleDetailInfoVos;
    }
}
