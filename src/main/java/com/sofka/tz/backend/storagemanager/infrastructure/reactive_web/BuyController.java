package com.sofka.tz.backend.storagemanager.infrastructure.reactive_web;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.usecases.buy.ManageBuyUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping(value = "/buy")
public class BuyController {

    private static final Logger logger = LoggerFactory.getLogger(BuyController.class);
    private final ManageBuyUseCase useCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Flux<Buy> findAll() {
        return useCase.findAllBuys();
    }

    @GetMapping("/paginate/{skip}:{limit}")
    private Flux<Buy> findAllPaginate(@PathVariable Integer skip, @PathVariable Integer limit) {
        return useCase.findAllPaginate(skip, limit);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Buy> saveBuy(@RequestBody Buy buy) {
        logger.info("Buy created {}", buy.toBuilder());
        return useCase.saveBuy(buy);
    }
}
