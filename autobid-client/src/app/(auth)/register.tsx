import { Link } from "expo-router";
import { View } from "react-native";
import { Button } from "react-native-paper";

export default function Register() {
	return (
		<View>
			<Link href="/(auth)/login" push asChild>
				<Button>Login</Button>
			</Link>
		</View>
	);
}
