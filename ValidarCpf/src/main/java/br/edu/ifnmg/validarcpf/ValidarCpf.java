/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.validarcpf;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
import java.util.Scanner;

import java.util.Scanner;

public class ValidarCpf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um CPF para validar: ");
        String cpf = scanner.nextLine();

        boolean isValid = Util.validarCPF(cpf);
        if (isValid) {
            System.out.println("CPF válido: " + cpf);
        } else {
            System.out.println("CPF inválido: " + cpf);
        }
    }
}


