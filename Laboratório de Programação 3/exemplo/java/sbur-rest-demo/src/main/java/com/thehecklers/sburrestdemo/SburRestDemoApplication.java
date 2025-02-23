package com.thehecklers.sburrestdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SburRestDemoApplication.class, args);
  }

}

@RestController
@RequestMapping("/bolachas")
class RestApiDemoController {
  private List<Bolacha> bolachas = new ArrayList<>();

  public RestApiDemoController() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try {
      bolachas.addAll(List.of(
          new Bolacha("Trakinas", "baunilha", formatter.parse("13/10/2025")),
          new Bolacha("Oreo", "chocolate", formatter.parse("12/10/2025")),
          new Bolacha("Marina", "morango", formatter.parse("11/10/2025")),
          new Bolacha("Tortinha", "limão", formatter.parse("10/10/2025"))));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @CrossOrigin(origins = "*")
  @GetMapping
  Iterable<Bolacha> getBolachas() {
    return bolachas;
  }
}

class Bolacha {
  private final String id;
  private String marca;
  private String sabor;
  private Date validade;

  public Bolacha() {
    this.id = UUID.randomUUID().toString();
    this.marca = "Desconhecida";
    this.sabor = "Desconhecido";
    this.validade = new Date();
  }

  public Bolacha(String id, String marca, String sabor, Date validade) {
    this.id = id;
    this.marca = marca;
    this.sabor = sabor;
    this.validade = validade;
  }

  public Bolacha(String marca, String sabor, Date validade) {
    this(UUID.randomUUID().toString(), marca, sabor, validade);
  }

  public String getId() {
    return id;
  }

  public String getMarca() {
    return marca;
  }

  public String getSabor() {
    return sabor;
  }

  public Date getValidade() {
    return validade;
  }
}
