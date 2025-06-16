package com.example.demo.models;

import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private int id;
    
    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 50, message = "Máximo 50 caracteres")
    @Column(length = 50, nullable = false)
   private String nombres;
    
    
    @Past(message = "La fecha debe ser en el pasado")
    @Column(nullable = false)
    private Date fechaNacimiento;
    
    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 50, message = "Máximo 50 caracteres")
    @Column(length = 50, nullable = false)
    private String apellidos;
    
    @NotBlank(message = "El tipo de documento es obligatorio")
    @Size(max = 10, message = "Máximo 10 caracteres")
    @Column(length = 10, nullable = false)
    private String tipoDoc;
    
    @NotBlank(message = "El número de identificación es obligatorio")
    @Size(max = 20, message = "Máximo 20 caracteres")
    @Column(length = 20, nullable = false, unique = true)
    private String numeroIdentificacion;
    
    @Email(message = "Debe ser un correo válido")
    @Size(max = 100, message = "Máximo 100 caracteres")
    @Column(length = 100, nullable = false, unique = true)

    private String correo;
    
    @Pattern(regexp = "^[0-9+]{7,15}$", message = "Solo números y el símbolo + (7-15 dígitos)")
    @Column(length = 15, nullable = false)
    private String celular;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        
    }
}