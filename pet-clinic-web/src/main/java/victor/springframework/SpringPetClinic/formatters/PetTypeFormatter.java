package victor.springframework.SpringPetClinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import victor.springframework.SpringPetClinic.model.PetType;
import victor.springframework.SpringPetClinic.services.PetTypeService;

import java.util.Collection;
import java.util.Locale;
import java.text.ParseException;

@Component
public class PetTypeFormatter implements Formatter<PetType> {


    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
