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
public class Enemy {

    @Id
    @Column(name = "enemy_id")
    @Comment("적 식별자")
    private Long id;

    @NotNull
    @Column(name = "enemy_name", length = 100)
    @Comment("적 이름")
    private String name;

    @Column(name = "enemy_explanation")
    @Comment("적 설명")
    private String explanation;

    @NotNull
    @Column(name = "enemy_physical_strength")
    @Comment("적 체력")
    private int physicalStrength;

    @NotNull
    @Column(name = "enemy_attack_power")
    @Comment("적 공격력")
    private int attackPower;

    @NotNull
    @Column(name = "enemy_defensive_power")
    @Comment("적 방어력")
    private int defensivePower;

    @NotNull
    @Column(name = "enemy_preemptive_status")
    @Comment("적 선공 여부")
    private Boolean preemptiveStatus;

    @NotNull
    @Column(name = "enemy_counterattack_status")
    @Comment("적 반격 여부")
    private Boolean counterattackStatus;
}
