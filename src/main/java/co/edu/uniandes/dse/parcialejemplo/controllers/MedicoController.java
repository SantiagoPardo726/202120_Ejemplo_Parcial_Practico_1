package co.edu.uniandes.dse.parcialejemplo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.edu.uniandes.dse.parcialejemplo.dto.MedicoDTO;
import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.services.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	@ResponseStatus(code =HttpStatus.OK)
	public List<MedicoDTO> findAll(){
		List<MedicoEntity> medicos = medicoService.getMedicos();
		return modelMapper.map(medicos, new TypeToken<List<MedicoDTO>>() {
		}.getType());
	}
}