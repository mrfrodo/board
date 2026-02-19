# Emberwar; a 2D boardgame 
Each game consist of a 10 by 10 board. 100 tiles.  
Each tile can be a plains, river or mountain.  
Each tile can have exactly one unit.  
Each game is controlled by one player.


emberwar
├─ EmberwarApp
├─ application
│  ├─ StartEmberwarService
│  └─ port
│     ├─ in
│     │  └─ StartEmberwarPort
│     └─ out
│        └─ BoardRepository
├─ domain
│  ├─ Board
│  ├─ BoardId
│  ├─ Square
│  └─ TileType
└─ infrastructure
    └─ persistence
        └─ jdbc
            └─ BoardJdbcRepository