package at.nacs.personaltodolist.view.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

  private String id;

  @NotEmpty
  private String title;
  private boolean done;

}
