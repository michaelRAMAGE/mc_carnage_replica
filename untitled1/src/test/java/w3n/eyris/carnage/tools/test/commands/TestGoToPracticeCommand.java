//package w3n.eyris.carnage.tools.test.commands;
//
//import be.seeseemelk.mockbukkit.MockBukkit;
//import be.seeseemelk.mockbukkit.ServerMock;
//import be.seeseemelk.mockbukkit.WorldMock;
//import be.seeseemelk.mockbukkit.entity.PlayerMock;
//import org.bukkit.entity.Player;
//import org.junit.jupiter.api.*;
//
//import w3n.eyris.carnage.tools.Main;
//import w3n.eyris.carnage.tools.commands.GoToPracticeCommand;
//
//// assumptions
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class TestGoToPracticeCommand {
//    private ServerMock server;
//    private Main plugin;
//
//    @BeforeEach
//    public void setUp()
//    {
//        server = MockBukkit.mock();
//        plugin = MockBukkit.load(Main.class);
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        MockBukkit.unmock();
//    }
//
//    @Test
//    @Order(1)
//    public void testPlayerOnPracticeServer() {
//        GoToPracticeCommand command = new GoToPracticeCommand(plugin);
//        PlayerMock player = server.addPlayer("eyris");
//        server.dispatchCommand(player, "goToPractice");
//
//    }
//
//    @Test
//    @Order(2)
//    public void testPlayerHasBasicInventory() {
//
//    }
//
//}
