package main.java.mii.miniproject.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEntitasToMatpel {
    private String namaPelajaran;
    private List<Long> entitas;
}
