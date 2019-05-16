package ru.cft.aml.battlecoordinator.controller.impl;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import ru.cft.aml.battlecoordinator.controller.Coordinator;
import ru.cft.aml.battlecoordinator.data.PlayerEntity;
import ru.cft.aml.battlecoordinator.data.PlayerRepository;
import ru.cft.aml.battlecoordinator.model.*;
import ru.cft.aml.battlecoordinator.players.Player;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api")
public class CoordinatorControllerImpl implements Coordinator {


    private final SimpMessagingTemplate template;

    private final Logger logger;

    private PlayerRepository repository;

    private Player firstShooter;

    @Autowired
    public CoordinatorControllerImpl(SimpMessagingTemplate template, PlayerRepository repository) {
        this.template = template;
        this.logger = LoggerFactory.getLogger(Coordinator.class);
        this.repository = repository;
    }

    @Override
    @PostMapping("online")
    @CrossOrigin("*")
    public List<String> online(String name, Integer id, String addr) {

        this.logger.info("handle online request from {}", id);

        if (repository.count() < 2) {
            PlayerEntity e = new PlayerEntity();
            e.setUiId(id);
            e.setPenaltyCount(0);
            e.setAddr(addr);
            repository.save(e);
            WebSocketUiMessage m = new WebSocketUiMessage();
            m.setName(name);
            m.setPlaygroundID(id);
            m.setType("team_name");
            template.setDefaultDestination("/events");
            template.convertAndSend(m);
        }

        return Collections.emptyList();
    }


    private ActionResult getSuccessResult() {
        ActionResult r = new ActionResult();
        r.setSuccess(true);
        return r;
    }

    @Override
    @PostMapping("start")
    @CrossOrigin("*")
    public ActionResult start(InitialRequest request) {
        repository.findAll().forEach(e -> {
            Player p = Feign.builder()
                    .logger(new feign.Logger.ErrorLogger())
                    .logLevel(feign.Logger.Level.FULL)
                    .contract(new SpringMvcContract())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .target(Player.class, e.getAddr());
            if (e.getUiId() == 0) {
                firstShooter = p;
                p.initPlayer(request.getZeroList());
            } else {
                p.initPlayer(request.getFirstList());
            }
        });

        this.firstShooter.run();

        return getSuccessResult();
    }

    @Override
    @PostMapping("report")
    @CrossOrigin("*")
    public ActionResult damageReport(DamageData data, Integer id) {
        return getSuccessResult();
    }

    @Override
    @PostMapping("stop")
    @CrossOrigin("*")
    public ActionResult stopGame(Integer id) {
        return getSuccessResult();
    }

    @Override
    @PostMapping("penalty")
    public ActionResult setPenalty(PenaltyData data, Integer id) {
        return getSuccessResult();
    }
}
