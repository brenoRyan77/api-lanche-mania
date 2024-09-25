package br.com.lanchemania.lanchemania.util.serializer;

import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CategoriaSerializer extends JsonSerializer<Categoria> {
    @Override
    public void serialize(Categoria categoria, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(categoria.getDescricao());
    }
}
