class Player(private val id: Int, private val name: String) {
    companion object {
        var role = "playable character"
        // fun getInfo(id: Int, name: String) = "$id, $name, $role"
    }

    fun getInfo() = "$id, $name, $role"
}

// fun getPlayerInfo(player: Player) = Player.getInfo(player.id, player.name)
fun getPlayerInfo(player: Player) = player.getInfo()
