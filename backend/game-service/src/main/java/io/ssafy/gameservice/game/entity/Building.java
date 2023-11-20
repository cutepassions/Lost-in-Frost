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
public class Building {

    @Id
    @Column(name = "buliding_id")
    @Comment("건축물 식별자")
    private Long id;

    @NotNull
    @Column(length = 100)
    @Comment("건축물 이름")
    private String name;

    @Comment("건축물 설명")
    private String explanation;

    @NotNull
    @Comment("건축물 내구도")
    private int durability;
}
