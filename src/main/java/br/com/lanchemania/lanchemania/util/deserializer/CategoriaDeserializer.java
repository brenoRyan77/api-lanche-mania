package br.com.lanchemania.lanchemania.util.deserializer;

import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CategoriaDeserializer extends JsonDeserializer<Categoria> {
    @Override
    public Categoria deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Categoria.fromDescricao(jsonParser.getText());
    }
}
