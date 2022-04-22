package hrms.hrms_backend.core.utilities.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jdi.Method;

public class GModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public <B, H> List<H> convert(List<B> entityList, Class<H> dto) {
        return entityList.stream().map(entity -> this.modelMapper.map(entityList, dto)).collect(Collectors.toList());
    }

    public <B, H> List<H> convertSpecial(List<B> entityList, Class<H> dto, List<Method> methodDto, List<Method> methodsEntity) {

        entityList.forEach(entity -> {
            try {
                H itemDto = dto.newInstance();
                methodDto.forEach(itemMethod -> {
                    try {
                        methodsEntity.get(methodDto.indexOf(itemMethod));
                        itemDto.getClass().getDeclaredMethod(itemMethod.name()).invoke(this);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException h) {
                        h.printStackTrace();
                    }
                });
            } catch (InstantiationException h) {
                h.printStackTrace();
            } catch (IllegalAccessException h) {
                h.printStackTrace();
            }
        });

        return null;
    }
}
