package br.edu.br.meuprimeirospringboot.entity;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tbl_aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(unique = true, length = 50, nullable = false)
	private String matricula;

	private String email;

	@Column(unique = true, length = 14, nullable = false)
	private String cpf;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtNascimento;

	@Transient
	private int idade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;

	}

	public int getIdade() {
		if (dtNascimento != null) {
			LocalDate birthDate = dtNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate currentDate = LocalDate.now();
			return Period.between(birthDate, currentDate).getYears();
		}

		return 0;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
