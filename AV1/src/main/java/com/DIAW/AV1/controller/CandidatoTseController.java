package com.DIAW.AV1.controller;

import com.DIAW.AV1.model.Candidato;
import com.DIAW.AV1.service.CandidatosTseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CandidatoTseController {

    private final CandidatosTseService candidatoTseService;

    public CandidatoTseController(CandidatosTseService candidatoTseService) {
        this.candidatoTseService = candidatoTseService;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String escolaridade,
            @RequestParam(required = false) Integer idadeMin,
            @RequestParam(required = false) Integer idadeMax,
            Model model) {

        candidatoTseService.filtrarPerfil(genero, escolaridade, idadeMin, idadeMax);

        return "candidato";
    }
}
