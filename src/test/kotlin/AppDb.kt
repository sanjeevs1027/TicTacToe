import com.typesafe.config.ConfigFactory
import edu.workshop.kotlin.game.database.Game
import edu.workshop.kotlin.game.database.Move
import edu.workshop.kotlin.game.database.Player
import edu.workshop.kotlin.game.module
import io.ktor.config.HoconApplicationConfig
import io.ktor.server.testing.TestApplicationEngine
import io.ktor.server.testing.createTestEnvironment
import org.jetbrains.exposed.sql.exists
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.BeforeClass
import kotlin.test.Test

class ApplicationDBTest {

    companion object {
        private val engine = TestApplicationEngine(createTestEnvironment {
            config = HoconApplicationConfig(ConfigFactory.load("application-test.conf"))
        })

        @BeforeClass
        @JvmStatic
        fun setup() {
            engine.start(wait = false)
            engine.application.module()
        }


    }

    @Test
    fun shouldHaveCreatedPlayerTable() {
        with(ApplicationDBTest.engine){
           transaction{
               assert(Player.exists())
           }
        }
    }

    @Test
    fun shouldHaveCreatedGameTable() {
        with(ApplicationDBTest.engine){
            transaction{
                assert(Game.exists())
            }
        }
    }

    @Test
    fun shouldHaveCreatedMoveTable() {
        with(ApplicationDBTest.engine){
            transaction{
                assert(Move.exists())
            }
        }
    }

}



