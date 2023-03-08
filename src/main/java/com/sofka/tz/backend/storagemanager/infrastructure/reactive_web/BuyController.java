package com.sofka.tz.backend.storagemanager.infrastructure.reactive_web;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.usecases.buy.ManageBuyUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Buy Rest Controller
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "buy")
public class BuyController {

    private final ManageBuyUseCase useCase;
    private static final Logger logger = LoggerFactory.getLogger(BuyController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Buy> findAll() {
        return useCase.findAllBuys();
    }

    @GetMapping("/paginate/{skip}:{limit}")
    public Flux<Buy> findAllPaginate(@PathVariable Integer skip, @PathVariable Integer limit) {
        return useCase.findAllPaginate(skip, limit);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Buy> saveBuy(@RequestBody Buy buy) {
        logger.info("Buy created {}", buy.toBuilder());
        return useCase.saveBuy(buy);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable String id) {
        return useCase.deleteById(id);
    }
}
