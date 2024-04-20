package CS489.miu.ads.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ModelMapperBean {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
