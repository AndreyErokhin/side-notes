@RunWith(JUnitParamsRunner.class)
public class UpdateNotificationSettingRequestTest {
    @Test
    @Parameters({"true|true", "true|false", "false|true", "false|false"})
    public void should_parse_json(boolean push, boolean email) {
        final var json = object()
            .put("email", email)
            .put("push", push)
            .toString();

        final var request = Json.parse(json, UpdateNotificationSettingRequest.class);

        assertThat(request.emailEnabled).isEqualTo(email);
        assertThat(request.pushEnabled).isEqualTo(push);
    }
}
