/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.validarcpf;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public class Util {
    public static int obterDigito(long numero, int posicao) {
        String numeroStr = Long.toString(numero);
        if (posicao < 1 || posicao > numeroStr.length()) {
            throw new IllegalArgumentException("Posição inválida");
        }

        int indice = numeroStr.length() - posicao;
        char digito = numeroStr.charAt(indice);

        return Character.getNumericValue(digito);
    }

    public static boolean validarCPF(long cpf) {
        String cpfStr = Long.toString(cpf);
        if (cpfStr.length() != 11) {
            return false;
        }

        int soma1 = 0;
        for (int i = 1; i <= 9; i++) {
            int digito = obterDigito(cpf, i);
            soma1 += digito * (11 - i);
        }
        int resto1 = (soma1 * 10) % 11;
        if (resto1 == 10) {
            resto1 = 0;
        }

        int soma2 = 0;
        for (int i = 1; i <= 10; i++) {
            int digito = obterDigito(cpf, i);
            soma2 += digito * (12 - i);
        }
        int resto2 = (soma2 * 10) % 11;
        if (resto2 == 10) {
            resto2 = 0;
        }

        return resto1 == obterDigito(cpf, 10) && resto2 == obterDigito(cpf, 11);
    }

    public static boolean validarCPF(String cpf) {
        
        cpf = cpf.replaceAll("[^0-9]", "");

        // Converte para long e chama o método de validação
        try {
            long cpfLong = Long.parseLong(cpf);
            return validarCPF(cpfLong);
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}

