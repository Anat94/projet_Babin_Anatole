package com.example.projet_babin_anatole.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VirementAspect {

    private static final Logger logger = LoggerFactory.getLogger("VIREMENT_AUDIT");

    @AfterReturning("execution(* com.example.projet_babin_anatole.service.AccountService.payment(..))")
    public void logVirement(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        Long source = (Long) args[0];
        Long dest = (Long) args[1];
        Double montant = (Double) args[2];

        logger.info("Virement effectue avec succes depuis {} vers {} d'un montant de {}", source, dest, montant);
    }
}