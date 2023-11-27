package io.ssafy.gameservice.game.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")
    @Comment("재료 식별자")
    private Long id;

    @NotNull
    @Column(name = "ingredient_name", length = 100)
    @Comment("재료 이름")
    private String name;

    @Column(name = "ingredient_explanation", length = 100)
    @Comment("재료 설명")
    private String explanation;
}
