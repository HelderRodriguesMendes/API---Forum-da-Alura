package br.com.alura.forumAlura_API.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrodeValidacaoHandler {

    @Autowired
    private MessageSource messageSource; // pega mensagens de erro de acordo com idioma requisitado

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrodeValidacaoDto> handle(MethodArgumentNotValidException exception){

        List<ErrodeValidacaoDto> errosPersonalizados = new ArrayList<>();

        List<FieldError> errosOcorridos = exception.getBindingResult().getFieldErrors();

        errosOcorridos.forEach(e ->{
            String mensagemDeErro = messageSource.getMessage(e, LocaleContextHolder.getLocale()); // LocaleContextHolder.getLocale() seleciona o idioma da mensagem
            ErrodeValidacaoDto erro = new ErrodeValidacaoDto(e.getField(), mensagemDeErro);
            errosPersonalizados.add(erro);
        });

        return errosPersonalizados;
    }
}
