import { theme } from "@/theme/theme";
import { Stack } from "expo-router";

export default function Layout() {
    return <Stack
            screenOptions={{
                headerStyle: { backgroundColor: theme.colors.background },
                headerTintColor: theme.colors.onBackground,
                contentStyle: { backgroundColor: theme.colors.background },
            }}/>
}