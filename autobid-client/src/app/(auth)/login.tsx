import { Link } from "expo-router";
import { useState } from "react";
import { StyleSheet, View } from "react-native";
import { Button, Text, TextInput } from "react-native-paper";
import { SafeAreaView } from "react-native-safe-area-context";

export default function Login() {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");

	return (
		<SafeAreaView style={styles.container}>
			<Text style={styles.h1}>Sign in to Autobid!</Text>
			<View style={styles.form}>
				<TextInput
					mode="outlined"
					label={"Email"}
					value={email}
					onChangeText={(email) => setEmail(email)}
				/>
				<TextInput
					mode="outlined"
					label={"Password"}
					value={password}
					onChangeText={(password) => setPassword(password)}
					secureTextEntry
				/>
			</View>
			<Link style={styles.loginBtn} href="/(app)/dashboard" push asChild>
				<Button mode="contained">Login</Button>
			</Link>
			<Link href="/(auth)/register" replace asChild>
				<Button>Don't have an account? Register here</Button>
			</Link>
		</SafeAreaView>
	);
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		margin: 30,
		justifyContent: "center",
		alignItems: "center",
	},
	form: {
		gap: 5,
		width: "100%",
	},
	h1: {
		textAlign: "center",
		fontWeight: 700,
		fontSize: 20,
		marginBottom: 30,
	},
	loginBtn: {
		width: "50%",
		marginTop: 15,
	},
});
