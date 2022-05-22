//package br.com.alura.forumAlura_API.controller;
//
//import br.com.alura.forumAlura_API.controller.form.LoginForm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/auth")
//public class AutenticacaoController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping
//    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm){
//
//        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
//
//         try {
//             Authentication authenticate = authenticationManager.authenticate(dadosLogin);
//
//             return ResponseEntity.ok().build();
//         }catch (AuthenticationException e){
//             return ResponseEntity.badRequest().build();
//         }
//    }
//}
