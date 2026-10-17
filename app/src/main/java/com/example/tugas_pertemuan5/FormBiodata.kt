package com.example.tugas_pertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodata(modifier: Modifier = Modifier) {
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggalLahir by remember { mutableStateOf("") }
    var textPengalaman by remember { mutableStateOf("") }
    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    var expandedPengalaman by remember { mutableStateOf(false) }
    val opsiPengalaman = listOf("0-1 tahun", "1-3 tahun", "3-5 tahun")
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var isProceedClicked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_ucl),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 36.dp)
                .background(Color.White, shape = CircleShape)
                .size(dimensionResource(id = R.dimen.height_menu_button)),
            onClick = { }
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.Gray
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen.radius_card_main),
                topEnd = dimensionResource(id = R.dimen.radius_card_main),
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_screen_horizontal))
                        .padding(top = dimensionResource(id = R.dimen.padding_form_vertical)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.title_biodata),
                        color = Color(0xFF6200EA),
                        fontSize = dimensionResource(id = R.dimen.font_title).value.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))
                    Text(
                        text = stringResource(id = R.string.subtitle_form_biodata),
                        color = Color.Gray,
                        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                            modifier = Modifier.weight(1f).padding(end = 6.dp),
                            label = { Text(stringResource(id = R.string.first_name), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                            onValueChange = {
                                textNamaDepan = it
                            }
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                            modifier = Modifier.weight(1f).padding(start = 6.dp),
                            label = { Text(stringResource(id = R.string.last_name), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                            onValueChange = {
                                textNamaBelakang = it
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                    OutlinedTextField(
                        value = textEmail,
                        singleLine = true,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(stringResource(id = R.string.email), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                        onValueChange = {
                            textEmail = it
                        }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = textTanggalLahir,
                            singleLine = true,
                            readOnly = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                            modifier = Modifier.weight(1f).padding(end = 6.dp),
                            label = { Text(stringResource(id = R.string.date_birth), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(Icons.Default.DateRange, contentDescription = "Pilih Tgl")
                                }
                            },
                            onValueChange = { }
                        )

                        ExposedDropdownMenuBox(
                            expanded = expandedPengalaman,
                            onExpandedChange = { expandedPengalaman = !expandedPengalaman },
                            modifier = Modifier.weight(1f).padding(start = 6.dp)
                        ) {
                            OutlinedTextField(
                                value = textPengalaman,
                                singleLine = true,
                                readOnly = true,
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                                modifier = Modifier.menuAnchor(),
                                label = { Text(stringResource(id = R.string.experience), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedPengalaman) },
                                onValueChange = { }
                            )
                            ExposedDropdownMenu(
                                expanded = expandedPengalaman,
                                onDismissRequest = { expandedPengalaman = false }
                            ) {
                                opsiPengalaman.forEach { opsi ->
                                    DropdownMenuItem(
                                        text = { Text(opsi, fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                                        onClick = {
                                            textPengalaman = opsi
                                            expandedPengalaman = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    Text(
                        text = stringResource(id = R.string.choose_skills),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(id = R.dimen.font_label).value.sp,
                        color = Color.Black
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isAndroidChecked,
                                onCheckedChange = {
                                    isAndroidChecked = it
                                }
                            )
                            Text(text = stringResource(id = R.string.android), fontSize = dimensionResource(id = R.dimen.font_label).value.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isUiUxChecked,
                                onCheckedChange = {
                                    isUiUxChecked = it
                                }
                            )
                            Text(text = stringResource(id = R.string.ui_ux), fontSize = dimensionResource(id = R.dimen.font_label).value.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isWebChecked,
                                onCheckedChange = {
                                    isWebChecked = it
                                }
                            )
                            Text(text = stringResource(id = R.string.web), fontSize = dimensionResource(id = R.dimen.font_label).value.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(fraction = 1f)
                            .height(dimensionResource(id = R.dimen.height_button)),
                        enabled = textNamaDepan.isNotEmpty() && textNamaBelakang.isNotEmpty() &&
                                textEmail.isNotEmpty() && textTanggalLahir.isNotEmpty() && textPengalaman.isNotEmpty(),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_button)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.blue),
                            disabledContainerColor = Color(0xFFE0E0E0)
                        ),
                        onClick = {
                            namaDepan = textNamaDepan
                            namaBelakang = textNamaBelakang
                            email = textEmail
                            tanggalLahir = textTanggalLahir
                            pengalaman = textPengalaman

                            val selectedSkills = mutableListOf<String>()
                            if (isAndroidChecked) selectedSkills.add("Android")
                            if (isUiUxChecked) selectedSkills.add("UI/UX")
                            if (isWebChecked) selectedSkills.add("Web")
                            skills = if (selectedSkills.isNotEmpty()) selectedSkills.joinToString(", ") else "-"

                            isProceedClicked = true
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.proceed),
                            fontSize = dimensionResource(id = R.dimen.font_button).value.sp,
                            color = Color.White
                        )
                    }
                }

                if (isProceedClicked) {
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFCFD8DC))
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_screen_horizontal),
                                vertical = dimensionResource(id = R.dimen.padding_card_result)
                            )
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(dimensionResource(id = R.dimen.padding_card_result))
                            ) {
                                Text(
                                    text = stringResource(id = R.string.result_title),
                                    color = colorResource(id = R.color.light_blue),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = dimensionResource(id = R.dimen.font_result_title).value.sp
                                )
                                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                                Text(text = "• " + stringResource(id = R.string.result_name) + " : " + namaDepan + " " + namaBelakang, color = Color.White, fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "• " + stringResource(id = R.string.result_date_birth) + " : " + tanggalLahir, color = Color.White, fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "• " + stringResource(id = R.string.result_experience) + " : " + pengalaman, color = Color.White, fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "• " + stringResource(id = R.string.result_email) + " : " + email, color = Color.White, fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "• " + stringResource(id = R.string.result_skills) + " : " + skills, color = Color.White, fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                }

                if (showDatePicker) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePicker = false },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    showDatePicker = false
                                    val selectedDateMillis = datePickerState.selectedDateMillis
                                    if (selectedDateMillis != null) {
                                        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                        textTanggalLahir = formatter.format(Date(selectedDateMillis))
                                    }
                                }
                            ) { Text("OK") }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDatePicker = false }) { Text("Batal") }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                    }
                }
            }
        }
    }
}