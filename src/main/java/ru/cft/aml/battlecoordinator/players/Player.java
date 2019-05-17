package ru.cft.aml.battlecoordinator.players;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.aml.battlecoordinator.model.ActionResult;
import ru.cft.aml.battlecoordinator.model.CellModel;

import java.util.List;

@RestController
@RequestMapping("/api")
public interface Player {


    @PostMapping(value = "/init", consumes = "application/json")
    ActionResult initPlayer(@RequestBody List<CellModel> cells);

    @PostMapping("/run")
    ActionResult run();

}
