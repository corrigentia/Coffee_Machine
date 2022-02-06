private const val HERO_BASE_STRENGTH = 1000
private const val HERO_WEAPON_STRENGTH = 300

private const val VILLAIN_BASE_STRENGTH = 500
private const val VILLAIN_WEAPON_STRENGTH = 700

class Hero {
    val baseStrength = HERO_BASE_STRENGTH

    class Equipment {
        val weapon = "trident"
        val weaponStrength = HERO_WEAPON_STRENGTH
    }
}

class Villain {
    val baseStrength = VILLAIN_BASE_STRENGTH

    class Equipment {
        val weapon = "bomb"
        val weaponStrength = VILLAIN_WEAPON_STRENGTH
    }
}

fun main() {
    val heroEquipment = Hero.Equipment()
    val heroTotalStrength = Hero().baseStrength + heroEquipment.weaponStrength

    val villainEquipment = Villain.Equipment()
    val villainTotalStrength = Villain().baseStrength + villainEquipment.weaponStrength

    // the following lines should remain as they are
    println("The hero uses ${heroEquipment.weapon}. The total strength is $heroTotalStrength.")
    println("The villain uses ${villainEquipment.weapon}. The total strength is $villainTotalStrength.")
}
