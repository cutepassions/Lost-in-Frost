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
public class Armor {

    @Id
    @Column(name = "armor_id")
    @Comment("방어구 식별자")
    private Long id;

    @NotNull
    @Column(name = "armor_name", length = 100)
    @Comment("방어구 이름")
    private String name;

    @Column(name = "armor_explanation")
    @Comment("방어구 설명")
    private String explanation;

    @NotNull
    @Column(name = "armor_durability")
    @Comment("방어구 내구도")
    private int durability;

    @NotNull
    @Column(name = "armor_defensive_power")
    @Comment("방어구 방어력")
    private int defensivePower;
}
