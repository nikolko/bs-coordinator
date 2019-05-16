package ru.cft.aml.battlecoordinator.controller;


import org.springframework.web.bind.annotation.*;
import ru.cft.aml.battlecoordinator.model.ActionResult;
import ru.cft.aml.battlecoordinator.model.DamageData;
import ru.cft.aml.battlecoordinator.model.InitialRequest;
import ru.cft.aml.battlecoordinator.model.PenaltyData;

import java.util.List;


@RestController
@RequestMapping("api")
public interface Coordinator {

    @PostMapping("online")
    List<String> online(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam("addr") String addr);

    @PostMapping("start")
    ActionResult start(@RequestBody InitialRequest request);


    @PostMapping("report")
    ActionResult damageReport(@RequestBody DamageData data, @RequestParam("id") Integer id);


    @PostMapping("stop")
    ActionResult stopGame(@RequestParam("id") Integer id);

    @PostMapping("penalty")
    ActionResult setPenalty(@RequestBody PenaltyData data, @RequestParam("id") Integer id);

}
