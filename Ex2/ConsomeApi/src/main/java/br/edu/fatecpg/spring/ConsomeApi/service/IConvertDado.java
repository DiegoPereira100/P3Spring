package br.edu.fatecpg.spring.ConsomeApi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConvertDado {
    <T> T obterDado(String json, Class<T> classe) throws JsonProcessingException;

}
