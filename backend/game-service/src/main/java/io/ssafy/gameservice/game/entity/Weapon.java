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
public class Weapon {

    @Id
    @Column(name = "weapon_id")
    @Comment("무기 식별자")
    private Long id;

    @NotNull
    @Column(name = "weapon_name", length = 100)
    @Comment("무기 이름")
    private String name;

    @Column(name = "weapon_explanation")
    @Comment("무기 설명")
    private String explanation;

    @NotNull
    @Column(name = "weapon_durability")
    @Comment("무기 내구도")
    private int durability;

    @NotNull
    @Column(name = "weapon_attack_power")
    @Comment("무기 공격력")
    private int attackPower;
}
