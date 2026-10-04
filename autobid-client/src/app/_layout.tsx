import { Stack } from "expo-router";
import { SafeAreaProvider } from "react-native-safe-area-context";
import { PaperProvider } from "react-native-paper";
import { theme } from "@/theme/theme";

export default function RootLayout() {
	return (
		<SafeAreaProvider>
			<PaperProvider theme={theme}>
				<Stack
					screenOptions={{
						headerStyle: { backgroundColor: theme.colors.background },
						headerTintColor: theme.colors.onBackground,
						contentStyle: { backgroundColor: theme.colors.background },
					}}
				/>
			</PaperProvider>
		</SafeAreaProvider>
	);
}
