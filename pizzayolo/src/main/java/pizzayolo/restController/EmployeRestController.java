package pizzayolo.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Employe;
import pizzayolo.services.EmployeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/employe")
public class EmployeRestController {

	@Autowired
	private EmployeService employeService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Employe> getAll() {
		return employeService.getAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public void create(@Valid @RequestBody Employe employe, BindingResult br) {
		employeService.create(employe);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Employe getById(@PathVariable Long id) {
		return employeService.getById(id);
	}

	

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Employe partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Employe employe = employeService.getById(id);
		// employe.setNom(fields.get("nom").toString());

		fields.forEach((k, v) -> {
//			if (k.equals("attributQuiPoseProbleme")) {   //adresse et employ�
//				;
//			}else {
			Field field = ReflectionUtils.findField(Employe.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, employe, v);
			// }
		});

		return employeService.update(employe);
	}

}
